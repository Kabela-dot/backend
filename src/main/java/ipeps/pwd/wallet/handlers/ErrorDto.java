package ipeps.pwd.wallet.handlers;

import ipeps.pwd.wallet.exceptions.erreursCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    private int httpcode;
    private erreursCodes codes;
    private String message;
    private List<String>errors = new ArrayList<>();
}
