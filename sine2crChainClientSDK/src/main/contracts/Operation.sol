pragma solidity ^0.4.25;
pragma experimental ABIEncoderV2;
import "./Factory.sol";

contract Operation{
    //为指定数据合约添加数据
    function setData(Data dataContract,int[] _data,string remark)public{
        dataContract.setData(_data,remark);
    }
    //查询指定数据合约数据
    function getData(Data dataContract)public view returns(Data.TraceData[] ){

        return dataContract.getData();
    }
    //创建分类合约
    function createCategory(Factory factory,uint64 datasGroup) public returns(Category){

        return factory.createCategory(datasGroup);

    }
    //创建数据合约
    function createDataContract(Factory factory,uint64 datasGroup, uint64 datasId) public returns(Data){
        return factory.createDataContract(datasGroup,datasId);
    }
    //创建工厂合约
    function createFactory() public returns(Factory)  {
        return new Factory();
    }
}
