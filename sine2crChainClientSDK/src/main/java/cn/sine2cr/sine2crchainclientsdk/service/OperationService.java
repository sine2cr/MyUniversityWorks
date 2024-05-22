package cn.sine2cr.sine2crchainclientsdk.service;

import cn.sine2cr.sine2crchainclientsdk.model.bo.OperationCreateCategoryInputBO;
import cn.sine2cr.sine2crchainclientsdk.model.bo.OperationCreateDataContractInputBO;
import cn.sine2cr.sine2crchainclientsdk.model.bo.OperationGetDataInputBO;
import cn.sine2cr.sine2crchainclientsdk.model.bo.OperationSetDataInputBO;
import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class OperationService {
  public static final String ABI = cn.sine2cr.sine2crchainclientsdk.utils.IOUtil.readResourceAsString("abi/Operation.abi");

  public static final String BINARY = cn.sine2cr.sine2crchainclientsdk.utils.IOUtil.readResourceAsString("bin/ecc/Operation.bin");

  public static final String SM_BINARY = cn.sine2cr.sine2crchainclientsdk.utils.IOUtil.readResourceAsString("bin/sm/Operation.bin");

  @Value("${system.contract.operationAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse setData(OperationSetDataInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "setData", input.toArgs());
  }

  public TransactionResponse createDataContract(OperationCreateDataContractInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "createDataContract", input.toArgs());
  }

  public TransactionResponse createCategory(OperationCreateCategoryInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "createCategory", input.toArgs());
  }

  public TransactionResponse createFactory() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "createFactory", Arrays.asList());
  }

  public CallResponse getData(OperationGetDataInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getData", input.toArgs());
  }
}
