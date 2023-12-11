SELECT 
    u.user_id, username, training_id, training_date, count(user_training_id) AS count
FROM USER u JOIN TRAINING_DETAILS t ON u.user_id = t.user_id
GROUP BY u.user_id, username, training_id, training_date
HAVING (count(user_training_id)) > 1
ORDER BY training_date DESC; 
