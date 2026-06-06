package it.san_mandato.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.san_mandato.entity.SourceEntity;
import it.san_mandato.enumeration.SourceTypeEnum;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, Long> {

	List<SourceEntity> findByPoiUuid(UUID poiUuid);

	/*
	 * ~~(class org.openrewrite.java.tree.J$Erroneous cannot be cast to class
	 * org.openrewrite.java.tree.J$Assignment (org.openrewrite.java.tree.J$Erroneous
	 * and org.openrewrite.java.tree.J$Assignment are in unnamed module of loader
	 * 'app'))~~>
	 */@Query("SELECT s FROM SourceEntity s WHERE s.uuid = :uuid")
	Optional<SourceEntity> findByUuid(UUID uuid);

	List<SourceEntity> findByPoiUuidAndTipologia(UUID poiUuid, SourceTypeEnum tipologia);
}