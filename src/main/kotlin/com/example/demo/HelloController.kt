package com.example.demo

import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Created by yongyeon on 2017-07-19.
 */
@Controller
class HelloController(var memberRepository: MemberRepository) {
    @RequestMapping(name = "list")
    @ResponseBody
    fun list (): String {
        return memberRepository.findAll().toString()
    }
}

data class Member (
        var name: String = "",
        var phone: Int = 0,
        var addr: String = ""
)

@RestController
class HelloRestController(var memberRepository: MemberRepository) {
    @GetMapping("/restlist")
    fun restList (): MutableList<MemberModel> {
        return memberRepository.findAll().toMutableList()
    }
    @GetMapping("/{name}")
    fun restList (@PathVariable name: String): String {
        return name
    }
    @GetMapping("/rest/name")
    fun restNameList (@RequestParam name: String): String {
        return name
    }
    @PostMapping("/rest/post")
    fun restPost(member: Member): String {
        var regMember: MemberModel = MemberModel()
        regMember.name = member.name
        regMember.phone = member.phone.toString()
        regMember.addr = member.addr
        memberRepository.save(regMember)
        return member.toString()
    }
}

