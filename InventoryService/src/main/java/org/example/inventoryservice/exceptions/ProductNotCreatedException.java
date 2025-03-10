package org.example.inventoryservice.exceptions;

public class ProductNotCreatedException extends RuntimeException {
  public ProductNotCreatedException(String message) {
    super(message);
  }
}
