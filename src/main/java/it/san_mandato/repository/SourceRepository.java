package it.san_mandato.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.san_mandato.entity.SourceEntity;
import it.san_mandato.enumeration.SourceTypeEnum;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, Long> {

	List<SourceEntity> findByPoiUuid(UUID poiUuid);

	Optional<SourceEntity> findByUuid(UUID uuid);

	List<SourceEntity> findByPoiUuidAndTipologia(UUID poiUuid, SourceTypeEnum tipologia);
}