package com.example.mad_project

class UserModel (
    var userid:String? = null,
    var name:String? = null,
    var email:String? = null,
    var phone:String? = null,
    var address:String? = null
)

class GuideModel(
    var guideid:String? =null,
    var name:String? = null,
    var email: String? =null,
    var nic:String? = null,
    var phone: String?=null,
    var description:String?=null,
    var language : ArrayList<String>? = null
)