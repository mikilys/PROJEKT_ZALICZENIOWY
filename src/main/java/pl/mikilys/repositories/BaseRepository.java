package pl.mikilys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.mikilys.entities.TttGame;

@Transactional

public interface BaseRepository extends JpaRepository<TttGame, Long> {

}
