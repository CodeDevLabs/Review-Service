package com.deafoodservice.app.reviewserice2.repository;

import com.deafoodservice.app.reviewserice2.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
