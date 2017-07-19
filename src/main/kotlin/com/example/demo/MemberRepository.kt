package com.example.demo

import org.springframework.data.repository.CrudRepository
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 * Created by yongyeon on 2017-07-19.
 */

@Entity
class MemberModel {
    @Id
    var name: String = ""
    @Column
    var phone: String = ""
    @Column
    var addr: String = ""
}

interface MemberRepository : CrudRepository<MemberModel, Long>
