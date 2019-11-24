package audience

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should return audience not found'
    request {
        method 'GET'
        url '/rest/audiences/146eca28-290a-485b-8718-e0b96128b041' // not exist audience
    }
    response {
        status 404
    }
}