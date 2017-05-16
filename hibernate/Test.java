package shiyanlou.test.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import shiyanlou.test.hibernate.entity.User;

public class Test {

    public static void main(String[] args) {

        // ��ȡ Hibernate ������Ϣ
        Configuration configuration = new Configuration().configure();
        @SuppressWarnings("deprecation")
        // ���� configuration ���� sessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // ���� session���൱�ڿ��� JDBC �� connection��
        Session session = sessionFactory.openSession();

        // �����������������
        session.beginTransaction();

        // �½����󣬲���ֵ
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("admin");

        // �������
        session.save(user);

        // �ύ����
        session.getTransaction().commit();

        // �ر� session �� sessionFactory
        session.close();
        sessionFactory.close();
    }
}