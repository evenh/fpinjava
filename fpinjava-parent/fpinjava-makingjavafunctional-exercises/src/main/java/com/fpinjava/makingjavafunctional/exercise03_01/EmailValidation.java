package com.fpinjava.makingjavafunctional.exercise03_01;


import static com.fpinjava.makingjavafunctional.exercise03_01.Result.failure;
import static com.fpinjava.makingjavafunctional.exercise03_01.Result.success;
import static com.fpinjava.makingjavafunctional.exercise03_02.Case.match;
import static com.fpinjava.makingjavafunctional.exercise03_02.Case.mcase;

import com.fpinjava.common.Function;
import java.util.regex.Pattern;

public class EmailValidation {

  static Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
  static Effect<String> success = email -> System.out.println("Mail sent to " + email);
  static Effect<String> failure = error -> System.err.println("Error occured: " + error);

  public static void main(String... args) {
    emailChecker.apply("this.is@my.email").bind(success, failure);
    emailChecker.apply(null).bind(success, failure);
    emailChecker.apply("").bind(success, failure);
    emailChecker.apply("john.doe@acme.com").bind(success, failure);
  }

  @SuppressWarnings("unchecked")
  static Function<String, Result<String>> emailChecker = s -> match(
      mcase(() -> success(s)),
      mcase(() -> s == null, () -> failure("email must not be null")),
      mcase(() -> s.length() == 0, () -> failure("email must not be empty")),
      mcase(() -> !emailPattern.matcher(s).matches(), () -> failure("email " + s + " is invalid"))
  );
}
