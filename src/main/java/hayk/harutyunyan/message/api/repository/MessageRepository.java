package hayk.harutyunyan.message.api.repository;

import hayk.harutyunyan.message.api.model.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
