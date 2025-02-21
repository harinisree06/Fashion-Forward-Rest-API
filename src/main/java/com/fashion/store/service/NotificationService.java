package com.fashion.store.service;

import com.fashion.store.model.Notification;
import com.fashion.store.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification createNotification(Long userId, String message) {
        Notification notification = new Notification(userId, message, LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long id, Notification updatedNotification) {
        return notificationRepository.findById(id).map(notification -> {
            notification.setMessage(updatedNotification.getMessage());
            notification.setTimestamp(updatedNotification.getTimestamp());
            return notificationRepository.save(notification);
        }).orElse(null);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
