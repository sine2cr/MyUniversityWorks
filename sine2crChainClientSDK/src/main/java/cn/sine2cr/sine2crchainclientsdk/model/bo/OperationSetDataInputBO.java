package cn.sine2cr.sine2crchainclientsdk.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationSetDataInputBO {
  private String dataContract;

  private List<BigInteger> _data;

  private String remark;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(dataContract);
    args.add(_data);
    args.add(remark);
    return args;
  }
}
