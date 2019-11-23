package audience

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should return audience'
    request {
        method 'get'
        url '/rest/audiences/c8937bbe-bfbf-4200-90d5-d23313d6ac4c'
    }
    response {
        status 200
        body([
                "audience_id": "c8937bbe-bfbf-4200-90d5-d23313d6ac4c",
                "ext_ids": [
                        "doubleclick": value(anyUuid())
                ],
                "segments": [
                        "6ebc39d5-e611-4e10-8b79-b487c4bd5951",
                        "b132054f-a7f3-49b1-b278-f5231c02e16c",
                        "ebc64f06-7de2-4247-b440-01b54083e1ae"
                ],
                "gender": value(anyOf("MALE", "FEMALE")),
                "age": value(anyPositiveInt())
        ])
    }
}