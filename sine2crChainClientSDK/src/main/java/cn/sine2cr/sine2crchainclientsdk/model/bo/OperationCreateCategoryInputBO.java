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
public class OperationCreateCategoryInputBO {
  private String factory;

  private BigInteger datasGroup;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(factory);
    args.add(datasGroup);
    return args;
  }
}
