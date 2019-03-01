import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer
{
    public static void main(String[] args) throws IOException
    {
        //服务器，指定端口
        ServerSocket server=new ServerSocket(8888);
        while(true){
            //2、接收多客户端连接、阻塞式
            Socket socket=server.accept();
            //3、发送数据 接受数据
            String msg="欢迎使用";
            /*//输出流
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(
                    socket.getOutputStream()));
            bw.write(msg);
            bw.newLine();
            bw.flush();*/

            //方法2
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}
