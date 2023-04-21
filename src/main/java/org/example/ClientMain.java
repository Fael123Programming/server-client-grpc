package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMain {
    private static final Logger logger = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress(Constants.IP_ADDRESS, Constants.PORT)
                .usePlaintext()
                .build();
        CalculatorGrpc.CalculatorBlockingStub calculatorStub = CalculatorGrpc.newBlockingStub(channel);
        NumberList numberList = NumberList.newBuilder()
                .addNumbers(Number.newBuilder().setNumber(2))
                .addNumbers(Number.newBuilder().setNumber(3))
                .build();
        Number sumResult = calculatorStub.sum(numberList);
        Number subResult = calculatorStub.sub(numberList);
        Number multResult = calculatorStub.mult(numberList);
        Number divResult = calculatorStub.div(numberList);
        Number powResult = calculatorStub.pow(numberList);
        logger.info("{} + {} = {}", numberList.getNumbers(0).getNumber(),
                numberList.getNumbers(1).getNumber(), sumResult.getNumber());
        logger.info("{} - {} = {}", numberList.getNumbers(0).getNumber(),
                numberList.getNumbers(1).getNumber(), subResult.getNumber());
        logger.info("{} * {} = {}", numberList.getNumbers(0).getNumber(),
                numberList.getNumbers(1).getNumber(), multResult.getNumber());
        logger.info("{} / {} = {}", numberList.getNumbers(0).getNumber(),
                numberList.getNumbers(1).getNumber(), divResult.getNumber());
        logger.info("{} ** {} = {}", numberList.getNumbers(0).getNumber(),
                numberList.getNumbers(1).getNumber(), powResult.getNumber());
    }
}