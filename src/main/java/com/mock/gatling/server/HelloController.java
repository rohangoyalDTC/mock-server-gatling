package com.mock.gatling.server;

import org.checkerframework.checker.units.qual.A;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class HelloController extends Controller {

  static AtomicInteger requests = new AtomicInteger(0);

  static ExecutorService es = Executors.newSingleThreadExecutor();

  public static void updateValue() {
    es.submit(() -> {
        System.out.println(requests.incrementAndGet());
    });
  }

  public CompletableFuture<Result> hello() {
    return CompletableFuture.supplyAsync(
        () -> {
          updateValue();
          System.out.println("OK:" + Thread.currentThread().getName());
          return ok();
        });
  }
}
