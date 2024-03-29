package com.toxind.benchmark.jvm.jmx.noti;

import javax.management.Notification;
import javax.management.NotificationListener;

public class ServerConfigureNotificationListener implements
		NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		log("SequenceNumber:" + notification.getSequenceNumber());
		log("Type:" + notification.getType());
		log("Message:" + notification.getMessage());
		log("Source:" + notification.getSource());
		log("TimeStamp:" + notification.getTimeStamp());
		log("UserData:" + notification.getUserData());
		
	}

	private void log(String message) {
		System.out.println(message);
	}

}