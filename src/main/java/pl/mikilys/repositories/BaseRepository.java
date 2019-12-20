package pl.mikilys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.mikilys.entities.TttBase;

@Repository
@Transactional

public interface BaseRepository extends JpaRepository<TttBase, Long> {

    @Query("select i from TttBase i where i.id=:gameId")
    TttBase findById(Long gameId);

}
