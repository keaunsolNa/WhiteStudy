package com.example.demo.menu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.menu.entity.Study;

/* Spring Data Jpa를 사용하면 JPA에서 사용했던 기존의 EntityManagerFactory, EntityManager, EntityTransaction같은 객체가 필요 없다.
 * (Spring Data Jpa 내부적으로 처리 됨)
 *
 * Repository는 DAO와 동일한 개념으로 사용되며 이 Repository를 이용하여 실질적인 데이터베이스 연동을 처리함
 * Repository 인터페이스들의 상속 구조
 * : Repository <- CrudRepository <- PagingAndSortingRepository <- JpaRepository
 *
 * Repository: 기능이 거의 없음
 * CrudRepository: 기본적인 CRUD 기능을 제공함
 * PagingAndSortingRepository: 페이징 및 정렬 처리하고자 할 경우 사용
 * JpaRepository: Spring Data Jpa에서 추가한 기능을 사용하고자 할 때 사용
 *                CrudRepository(CRUD)와 PagingAndSortingRepository(페이징 및 정렬)가 제공하는 모든 기능을 제공하고, 추가적으로 JPA에 특화된 메서드를 제공하므로
 *                단순 CRUD에 페이징 및 정렬을 추가하고 싶다면 JpaRepository를 사용
 *
 *
 * JpaRepository 인터페이스의 메소드를 테스트 해 보자.(정확히는 상위의 CrudRepository 인터페이스가 제공하는 메소드)
 * long count(): 모든 엔티티의 개수 리턴
 * void delete(ID): 식별 키를 통한 삭제
 * void delete(Iterable<? Extends T>): 주어진 모든 엔티티 삭제
 * boolean exist(ID): 식별 키를 가진 엔티티가 존재 하는지 확인
 * findAllById(ID): 모든 엔티티 목록 리턴
 * Iterable<T> findAll(Iterble<ID>): 해당 식별 키를 가진 엔티티 목록 리턴
 * Optional<T> findById(ID): 해당 식별 키에 해당하는 단일 엔티티 리턴
 * saveAll<Iterable>: 여러 엔티티들을 한 번에 등록, 수정
 * <S extends T>S save<S entity>: 하나의 엔티티를 등록, 수정
 *
 * 쿼리 메소드
 * : JPQL을 메소드로 대신 처리할 수 있도록 제공하는 기능
 *   메소드의 이름으로 필요한 쿼리를 만들어주는 기능으로 "find + 엔티티 이름 + By + 변수 이름"과 같이 네이밍 룰만 알면 사용 가능하다.
 *   ex) findMenuByCode(): Menu 엔티티에서 Code 속성에 대해 조건처리하여 조회한다.
 *
 *   엔티티 이름을 생략하고 쓸 수도 있는데 이는 해당 Repository 인터페이스의 제네릭에 해당하는 엔티티를 자동으로 인식하기 때문이다.
 *   ex) Repository 인터페이스가 JpaRepository<Menu, Integer>를 상속받고 있다면,
 *       findByCode(): Menu 엔티티에서 Code 속성에 대해 조건처리하여 조회한다.
 *
 * 쿼리 메소드 유형
 * And						ex) findByCodeAndName -> where x.code =?1 and x.name = ?2
 * Or						ex) findByCodeOrName -> where x.code =?1 or x.name = ?2
 * Between					ex) findByPriceBetween -> where x.price between ?1 and ?2
 * LessThan					ex) findByPriceLessThan -> where x.price < ?1
 * LessThanEqual			ex) findByPriceLessThanEquals -> where x.price <= ?1
 * GreaterThan				ex) findByPriceGreaterThan -> where x.price > ?1
 * GreaterThanEqual			ex) findByPriceGreaterThanEqual -> where x.price >= ?1
 * After					ex) findByDateAfter -> where x.date > ?1
 * Before					ex) findByDateBefore -> where x.date < ?1
 * IsNull					ex) findByNameIsNull -> where x.name is null
 * IsNotNull, NotNull		ex) findByName(Is)NotNull -> where x.name is not null
 * Like						ex) findByNameLike -> where x.name like ?1
 * NotLike					ex) findByNameNotLike -> where x.name not like ?1
 * StartingWidh				ex) findByNameStartingWith -> where x.name like ?1||'%'
 * EndingWith				ex) findByNameEndingWith -> where x.name like '%'||?1
 * Containing				ex) findByNameContainign -> where x.name like '%'||?1||'%'
 * OrderBy					ex) findByPriceOrderByCodeDesc -> where x.price = ?1 order by x.code desc
 * Not						ex) findByNameNot -> where x.name <> ?1
 * In						ex) findByNameIn(Collection<Name> names) -> where x.name in ?1
 */

public interface MenuRepository extends JpaRepository<Study, Integer>{


	int countByNameContaining(String searchValue);

    int countByDescriptionContaining(String description);
    
    List<Study> findByNameContaining(String searchValue, Pageable paging);

    List<Study> findByDescriptionContaining(String description, Pageable paging);
}
