package DMPApi

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should return created segment'
    request {
        method 'post'
        url '/rest/segments'
        body([
                segment_id: value(anyUuid()),
                segment_source_id: value(anyUuid()),
                segment_name: 'first segment',
                segment_owner: 'adclick',
                segment_type: 'ONLINE',
                meta_data: {},
                duration: value(anyPositiveInt())
        ])
        headers {
            contentType(applicationJsonUtf8())
        }
    }
    response {
        status 201
        body([
                "segment_id": fromRequest().body('$.segment_id'),
                "segment_source_id": fromRequest().body('$.segment_source_id'),
                "segment_name": fromRequest().body('$.segment_name'),
                "segment_owner": fromRequest().body('$.segment_owner'),
                "segment_type": fromRequest().body('$.segment_type'),
                "meta_data": fromRequest().body('$.meta_data'),
                "duration": fromRequest().body('$.duration'),
        ])
    }
}