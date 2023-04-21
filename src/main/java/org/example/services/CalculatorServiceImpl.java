package org.example.services;

import io.grpc.stub.StreamObserver;
import org.example.CalculatorGrpc;
import org.example.Number;
import org.example.NumberList;

public class CalculatorServiceImpl extends CalculatorGrpc.CalculatorImplBase {
    @Override
    public void sum(NumberList request, StreamObserver<Number> responseObserver) {
        float number = 0;
        for (Number n : request.getNumbersList()) {
            number += n.getNumber();
        }
        responseObserver.onNext(Number.newBuilder().setNumber(number).build());
        responseObserver.onCompleted();
    }

    @Override
    public void sub(NumberList request, StreamObserver<Number> responseObserver) {
        float number = request.getNumbersList().get(0).getNumber();
        for (int i = 1; i < request.getNumbersList().size(); i++) {
            number -= request.getNumbersList().get(i).getNumber();
        }
        responseObserver.onNext(Number.newBuilder().setNumber(number).build());
        responseObserver.onCompleted();
    }

    @Override
    public void mult(NumberList request, StreamObserver<Number> responseObserver) {
        float number = request.getNumbersList().get(0).getNumber();
        for (int i = 1; i < request.getNumbersList().size(); i++) {
            number *= request.getNumbersList().get(i).getNumber();
        }
        responseObserver.onNext(Number.newBuilder().setNumber(number).build());
        responseObserver.onCompleted();
    }

    @Override
    public void div(NumberList request, StreamObserver<Number> responseObserver) {
        float number = request.getNumbersList().get(0).getNumber();
        for (int i = 1; i < request.getNumbersList().size(); i++) {
            number /= request.getNumbersList().get(i).getNumber();
        }
        responseObserver.onNext(Number.newBuilder().setNumber(number).build());
        responseObserver.onCompleted();
    }

    @Override
    public void pow(NumberList request, StreamObserver<Number> responseObserver) {
        float number = request.getNumbersList().get(0).getNumber();
        for (int i = 1; i < request.getNumbersList().size(); i++) {
            number = (float) Math.pow(number, request.getNumbersList().get(i).getNumber());
        }
        responseObserver.onNext(Number.newBuilder().setNumber(number).build());
        responseObserver.onCompleted();
    }
}
