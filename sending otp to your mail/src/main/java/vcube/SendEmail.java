package vcube;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
public String getRandom()
{
Random rnd=new Random();

int number=rnd.nextInt(999999);
return String.format("%6d",number);	
}

public boolean sendEmail(User user) {
	boolean test=false;
	String toEmail=user.getEmail();
	String fromEmail="gayatrigangumalla111@gmail.com";
	String password="erbi fjag pbid klwj";
	


try {
	Properties pr=new Properties();
	pr.setProperty("mail.smtp.host", "smtp.gmail.com");
	pr.setProperty("mail.smtp.port", "587");
	
	pr.setProperty("mail.smtp.auth", "true");
	pr.setProperty("mail.smtp.starttls.enable", "true");
	
	
	Session session =Session.getInstance(pr,new Authenticator()
			{
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(fromEmail,password);
	
	}
			});
	Message mess=new MimeMessage(session);
	mess.setFrom(new InternetAddress(fromEmail));
	mess.setRecipient(Message.RecipientType.TO,new  InternetAddress(toEmail));
	mess.setText("registered sucessfully,please Registered OTP:"+user.getCode());
	mess.setSubject("user email verification");
	Transport.send(mess);
	test=true;
}
catch(Exception e) {
	e.printStackTrace();
}
return test;
}
}
