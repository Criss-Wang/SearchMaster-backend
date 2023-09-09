use my_db;

-- Insert sample data into the 'user' table
INSERT INTO user (userAccount, userPassword, unionId, mpOpenId, userName, userAvatar, userProfile, userRole, createTime, updateTime, isDelete)
VALUES
    ('user1@example.com', 'password1', 'wechatid1', 'openid1', 'John Doe', 'avatar1.jpg', 'I love programming!', 'user', NOW(), NOW(), 0),
    ('user2@example.com', 'password2', 'wechatid2', 'openid2', 'Alice Smith', 'avatar2.jpg', 'Coffee enthusiast and coder', 'user', NOW(), NOW(), 0),
    ('user3@example.com', 'password3', 'wechatid3', 'openid3', 'Bob Johnson', 'avatar3.jpg', 'Web developer and traveler', 'user', NOW(), NOW(), 0);

-- Insert sample data into the 'post' table
INSERT INTO post (title, content, tags, thumbNum, favourNum, userId, createTime, updateTime, isDelete)
VALUES
    ('First Post', 'This is my first post content.', '["programming", "coding"]', 5, 10, 1, NOW(), NOW(), 0),
    ('Recipe Share', 'Delicious recipe for chocolate cake.', '["cooking", "food"]', 3, 8, 2, NOW(), NOW(), 0),
    ('Travel Diary', 'Exploring the world and sharing experiences.', '["travel", "adventure"]', 8, 15, 3, NOW(), NOW(), 0);

-- Insert sample data into the 'post_thumb' table (likes)
INSERT INTO post_thumb (postId, userId, createTime, updateTime)
VALUES
    (1, 1, NOW(), NOW()),
    (1, 2, NOW(), NOW()),
    (2, 2, NOW(), NOW()),
    (3, 1, NOW(), NOW()),
    (3, 3, NOW(), NOW()),
    (3, 2, NOW(), NOW());

-- Insert sample data into the 'post_favour' table (saves)
INSERT INTO post_favour (postId, userId, createTime, updateTime)
VALUES
    (1, 1, NOW(), NOW()),
    (2, 2, NOW(), NOW()),
    (2, 1, NOW(), NOW()),
    (3, 3, NOW(), NOW()),
    (4, 1, NOW(), NOW());
