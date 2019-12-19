package pl.mikilys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.mikilys.entities.TttMove;

import java.util.List;

@Transactional

public interface MoveRepository extends JpaRepository <TttMove, Long> {

    public List<TttMove> findAllByGameId(@Param("id") Long id);

}
