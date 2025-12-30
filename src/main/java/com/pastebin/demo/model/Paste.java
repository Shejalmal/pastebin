package com.pastebin.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pastes")
public class Paste {

    @Id
    private String id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "max_views")
    private Integer maxViews;

    @Column(name = "view_count")
    public int viewCount = 0;

    // Standard Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getExpiresAt() { return expiresAt; }
    public void setExpiresAt(LocalDateTime expiresAt) { this.expiresAt = expiresAt; }

    public Integer getMaxViews() { return maxViews; }
    public void setMaxViews(Integer maxViews) { this.maxViews = maxViews; }

    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }
}