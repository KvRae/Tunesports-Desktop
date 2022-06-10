/*
 * Copyright (c) 2022.
 * Written By KvRae.
 * I hate writing documentations.
 *
 */
package Tests;

import Entities.Reservation;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.Date;

public class SmsSender {
  public static final String ACCOUNT_SID = "AC19b0e55100ddd4eedee1bd8698aba4ab";
  public static final String AUTH_TOKEN = "5762e5b4e97dae7be66300f33cbc786e";

  public static void send(Reservation r) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message =
        Message
            .creator(new com.twilio.type.PhoneNumber("+21699026017"),
                     "MGfab6dcc660946e7a4cfaaa4d8d62bc7f",
                     "Reservation Numero: " + r.getIdRes() +
                         " Registered Successfully at " +
                         java.time.LocalDate.now() + "")
            .create();

    System.out.println(message.getSid());
  }
}