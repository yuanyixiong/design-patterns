package com.behavior;

/**
 * 命令模式 客户、服务员、初始、点餐(命令)
 *
 * @ClassName: CommandPattern
 * @Author： yuanyixiong
 * @Date： 2019/12/11 下午2:37
 * @Description： TODO
 * @Version： 1.0
 */
public class CommandPattern {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);

        invoker.executeCommand();
    }
}


/**
 * 命令的调用者-服务员
 *
 * @Author: yuanyixiong
 * @Date: 2019/12/11 下午2:46
 * @Description: TODO
 * @Param:
 * @Version: 1.0
 * @Return:
 **/
class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }

}

/**
 * 命令的执行者-厨师
 *
 * @ClassName: Receiver
 * @Author: yuanyixiong
 * @Date: 2019/12/11 下午2:46
 * @Description: TODO
 * @Version: 1.0
 */
class Receiver {

    public void action() {
        System.out.println("Receiver  action");
    }
}

/**
 * 命令-做菜
 *
 * @ClassName: Command
 * @Author: yuanyixiong
 * @Date: 2019/12/11 下午2:46
 * @Description: TODO
 * @Version: 1.0
 */
abstract class Command {

    Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}

/**
 * 命令的具体实现-做菜-糖醋鱼
 *
 * @ClassName: ConcreteCommand
 * @Author: yuanyixiong
 * @Date: 2019/12/11 下午2:46
 * @Description: TODO
 * @Version: 1.0
 */
class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.action();
    }
}