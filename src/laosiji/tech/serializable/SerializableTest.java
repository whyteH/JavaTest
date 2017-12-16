package laosiji.tech.serializable;

import java.io.File;

/*
* 测试序列化对象改变类型后不能正常读取
*/
public class SerializableTest {

    private static final String fileName = "Person";

    public static void main(String[] args) {
        String path = new SerializableTest().getPath();
        Person person = new Person();
        person.setAge(1);
        person.setName("Whyte");
        person.setSexy(1);
        File file = new File(path, fileName);
//        FileUtil.writeObjectToFile(file, person);

        Person p = (Person) FileUtil.readObjectFromFile(file);
        System.out.print(p.getName() + "---" + p.getAge());
    }

    public String getPath() {
        return this.getClass().getResource("/").getPath();
    }

}
