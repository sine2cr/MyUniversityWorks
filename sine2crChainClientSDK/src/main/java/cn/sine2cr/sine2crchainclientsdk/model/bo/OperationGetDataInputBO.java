package cn.sine2cr.sine2crchainclientsdk.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationGetDataInputBO {
  private String dataContract;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(dataContract);
    return args;
  }
}
