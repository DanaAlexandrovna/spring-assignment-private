package ro.sda.javaro35.finalProject.entities.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressRequest {
    private final Long id;
    private final String country;
    private final String address;
}