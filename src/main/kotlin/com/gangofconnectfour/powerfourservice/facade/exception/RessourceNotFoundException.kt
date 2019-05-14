package com.gangofconnectfour.powerfourservice.facade.exception

class RessourceNotFoundException(message : String) : Exception("Resource non trouve : "+ message) {
}