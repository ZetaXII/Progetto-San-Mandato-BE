package it.san_mandato.specifications;

import org.springframework.data.jpa.domain.Specification;

import it.san_mandato.entity.PoiEntity;

public class PoiSpecifications {

	public static Specification<PoiEntity> hasName(String name) {
		return (root, query, cb) -> name == null ? null
				: cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
	}

	public static Specification<PoiEntity> hasAreaGroup(String areaGroup) {
		return (root, query, cb) -> areaGroup == null ? null
				: cb.like(cb.lower(root.get("areaGroup")), "%" + areaGroup.toLowerCase() + "%");
	}

	public static Specification<PoiEntity> hasConstructionCentury(String century) {
		return (root, query, cb) -> century == null ? null
				: cb.like(cb.lower(root.get("constructionCentury")), "%" + century.toLowerCase() + "%");
	}

	public static Specification<PoiEntity> hasGeneralDescription(String desc) {
		return (root, query, cb) -> desc == null ? null
				: cb.like(cb.lower(root.get("generalDescription")), "%" + desc.toLowerCase() + "%");
	}

	public static Specification<PoiEntity> hasAddress(String address) {
		return (root, query, cb) -> address == null ? null
				: cb.like(cb.lower(root.get("address")), "%" + address.toLowerCase() + "%");
	}

	public static Specification<PoiEntity> isLocalized(Boolean localized) {
		return (root, query, cb) -> localized == null ? null : cb.equal(root.get("isLocalized"), localized);
	}
}
