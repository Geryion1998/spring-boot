namespace java com.example.thrift.impl

exception InvalidOperationException {
    1: i32 code,
    2: string description
}

service LxdManagerService {

    bool TestCpu(1:string node, 2:i32 cpus, 3:i32 time) throws (1:InvalidOperationException e),

    bool Ping() throws (1:InvalidOperationException e)
}