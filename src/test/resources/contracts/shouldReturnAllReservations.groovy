package contracts

import org.apache.http.HttpStatus
import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.MediaType

Contract.make {
    description("should return all reservations")
    request {
        method("Get")
        url("/reservations")
    }

    response {
        status(HttpStatus.SC_OK)
        headers {
            ContentType(MediaType.APPLICATION_JSON)
        }
        body([[id: "1", name: "sohel"]])
    }
}