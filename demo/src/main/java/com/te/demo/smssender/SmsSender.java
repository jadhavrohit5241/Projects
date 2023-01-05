package com.te.demo.smssender;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.te.demo.dto.SmsDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.Getter;

@Component
@Getter
@Configuration
public class SmsSender {

	private final String ACCOUNT_SID = "AC49ac3b33fb7c29435edb7058fbbe20e1";

	private final String AUTH_TOKEN = "f93ddcf5a7d774cafa2b69ab297ce982";

	private final String FROM_NUMBER = "9197649 10574";

	public void send(SmsDto smsDto) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String smsmessage = " YOUR OPT IS :-" + genrateOtp() + " " + "PLEASE VARIFY UR OTP ";
		 Message.creator(new PhoneNumber(smsDto.getMobNo()),
				new PhoneNumber(FROM_NUMBER), smsmessage).create();

	}

	public static int genrateOtp() {
		return (int)( Math.random() * 10000);
	}
}
