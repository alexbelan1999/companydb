import pckg.*;

import java.sql.*;
import java.util.*;

public class Storage {
    @SuppressWarnings("unchecked")
    private static String jdbcUrl = null;
    private static String jdbcUser = null;
    private static String jdbcPassword = null;

    public static void init(String jdbcDriver,
                            String jdbcUrl,
                            String jdbcUser,
                            String jdbcPassword)
            throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        Storage.jdbcUrl = jdbcUrl;
        Storage.jdbcUser = jdbcUser;
        Storage.jdbcPassword = jdbcPassword;
    }

    public static Collection<Teacher> readAllTeachers() throws SQLException {
        String sql = "SELECT `id`, `name`, `surname`, `patronomyc`, `cathedraID`, `post`, `rate`, `right`," +
                " `lectionHours`, `practiceHours`, `labsHours`,  `consultHours`, `examHours`, `creditHours`, " +
                "`testHours`, `audienceHours`, `nonAudienceHours`, `totalHours` FROM `teacher`";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<Teacher> objects = new ArrayList<>();
            while(r.next()) {
                Teacher object = new Teacher();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setSurname(r.getString("surname"));
                object.setPatronomyc(r.getString("patronomyc"));
                object.setCathedraId(r.getInt("cathedraID"));
                object.setPost(r.getString("post"));
                object.setRate(r.getInt("rate"));
                object.setRight(r.getBoolean("right"));
                object.setLectionHours(r.getInt("lectionHours"));
                object.setPracticeHours(r.getInt("practiceHours"));
                object.setPracticeHours(r.getInt("labsHours"));
                object.setPracticeHours(r.getInt("consultHours"));
                object.setPracticeHours(r.getInt("examHours"));
                object.setPracticeHours(r.getInt("creditHours"));
                object.setPracticeHours(r.getInt("testHours"));
                object.setPracticeHours(r.getInt("audienceHours"));
                object.setPracticeHours(r.getInt("nonAudienceHours"));
                object.setPracticeHours(r.getInt("totalHours"));
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Teacher readTeacherById(Integer id) throws SQLException {
        String sql = "SELECT `id`, `name`, `surname`, `patronomyc`, `cathedraID`, `post`, `rate`, `right`," +
                                " `lectionHours`, `practiceHours`, `labsHours`,  `consultHours`, `examHours`, `creditHours`, " +
                                "`testHours`, `audienceHours`, `nonAudienceHours`, `totalHours` FROM `teacher` WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            Teacher object = null;
            if(r.next()) {
                object = new Teacher();
                object.setId(id);
                object.setName(r.getString("name"));
                object.setSurname(r.getString("surname"));
                object.setPatronomyc(r.getString("patronomyc"));
                object.setCathedraId(r.getInt("cathedraID"));
                object.setPost(r.getString("post"));
                object.setRate(r.getInt("rate"));
                object.setRight(r.getBoolean("right"));
                object.setLectionHours(r.getInt("lectionHours"));
                object.setPracticeHours(r.getInt("practiceHours"));
                object.setLabsHours(r.getInt("labsHours"));
                object.setConsultHours(r.getInt("consultHours"));
                object.setExamHours(r.getInt("examHours"));
                object.setCreditHours(r.getInt("creditHours"));
                object.setTestHours(r.getInt("testHours"));
                object.setAudienceHours(r.getInt("audienceHours"));
                object.setNonAudienceHours(r.getInt("nonAudienceHours"));
                object.setTotalHours(r.getInt("totalHours"));
            }
            return object;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Collection<Teacher> readTeachersByCathedraId(Integer id) throws SQLException {
        String sql = "SELECT `id`, `name`, `surname`, `patronomyc`, `cathedraID`, `post`, `rate`, `right`," +
                " `lectionHours`, `practiceHours`, `labsHours`,  `consultHours`, `examHours`, `creditHours`, " +
                "`testHours`, `audienceHours`, `nonAudienceHours`, `totalHours` FROM `teacher` WHERE `cathedraId` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            Collection<Teacher> objects = new ArrayList<>();
            while(r.next()) {
                Teacher object = new Teacher();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setSurname(r.getString("surname"));
                object.setPatronomyc(r.getString("patronomyc"));
                object.setCathedraId(r.getInt("cathedraID"));
                object.setPost(r.getString("post"));
                object.setRate(r.getInt("rate"));
                object.setRight(r.getBoolean("right"));
                object.setLectionHours(r.getInt("lectionHours"));
                object.setPracticeHours(r.getInt("practiceHours"));
                object.setLabsHours(r.getInt("labsHours"));
                object.setConsultHours(r.getInt("consultHours"));
                object.setExamHours(r.getInt("examHours"));
                object.setCreditHours(r.getInt("creditHours"));
                object.setTestHours(r.getInt("testHours"));
                object.setAudienceHours(r.getInt("audienceHours"));
                object.setNonAudienceHours(r.getInt("nonAudienceHours"));
                object.setTotalHours(r.getInt("totalHours"));
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Collection<Teacher> readSortedTeachersByCathedraId(Integer id, String parameter) throws SQLException {
        String sql = "SELECT `id`, `name`, `surname`, `patronomyc`, `cathedraID`, `post`, `rate`, `right`," +
                " `lectionHours`, `practiceHours`, `labsHours`,  `consultHours`, `examHours`, `creditHours`, " +
                "`testHours`, `audienceHours`, `nonAudienceHours`, `totalHours` FROM `teacher` WHERE `cathedraId` = ? ORDER BY `" + parameter +"` DESC";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            //s.setString(2, parameter);
            r = s.executeQuery();
            Collection<Teacher> objects = new ArrayList<>();
            while(r.next()) {
                Teacher object = new Teacher();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setSurname(r.getString("surname"));
                object.setPatronomyc(r.getString("patronomyc"));
                object.setCathedraId(r.getInt("cathedraID"));
                object.setPost(r.getString("post"));
                object.setRate(r.getInt("rate"));
                object.setRight(r.getBoolean("right"));
                object.setLectionHours(r.getInt("lectionHours"));
                object.setPracticeHours(r.getInt("practiceHours"));
                object.setLabsHours(r.getInt("labsHours"));
                object.setConsultHours(r.getInt("consultHours"));
                object.setExamHours(r.getInt("examHours"));
                object.setCreditHours(r.getInt("creditHours"));
                object.setTestHours(r.getInt("testHours"));
                object.setAudienceHours(r.getInt("audienceHours"));
                object.setNonAudienceHours(r.getInt("nonAudienceHours"));
                object.setTotalHours(r.getInt("totalHours"));
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }


    public static void createTeacher(Teacher object) throws SQLException {
        String sql = "INSERT INTO `teacher`(`name`, `surname`, `patronomyc`, `cathedraID`, `post`, `rate`, `right`," +
                "                                `lectionHours`, `practiceHours`, `labsHours`,  `consultHours`, `examHours`, `creditHours`, " +
                "                                `testHours`, `audienceHours`, `nonAudienceHours`, `totalHours` )" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getName());
            s.setString(2, object.getSurname());
            s.setString(3, object.getPatronomyc());
            s.setInt(4, object.getCathedraId());
            s.setString(5, object.getPost());
            s.setInt(6, object.getRate());
            s.setBoolean(7, object.getRight());
            s.setInt(8, object.getLectionHours());
            s.setInt(9, object.getPracticeHours());
            s.setInt(10, object.getLabsHours());
            s.setInt(11, object.getConsultHours());
            s.setInt(12, object.getExamHours());
            s.setInt(13, object.getCreditHours());
            s.setInt(14, object.getTestHours());
            s.setInt(15, object.getAudienceHours());
            s.setInt(16, object.getNonAudienceHours());
            s.setInt(17, object.getTotalHours());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void updateTeacher(Teacher object) throws SQLException {
        String sql = "UPDATE `teacher` SET `name` = ?, `surname` = ?, `patronomyc` = ?, `cathedraID` = ?, " +
                "`post` = ?, `rate` = ?, `right` = ?, `lectionHours` = ?, `practiceHours` = ?, `labsHours` = ?, " +
                "`consultHours` = ?, `examHours` = ?, `creditHours` = ?, `testHours` = ?, `audienceHours` = ?, " +
                "`nonAudienceHours` = ?, `totalHours` = ? WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getName());
            s.setString(2, object.getSurname());
            s.setString(3, object.getPatronomyc());
            s.setInt(4, object.getCathedraId());
            s.setString(5,object.getPost());
            s.setInt(6,object.getRate());
            s.setBoolean(7, object.getRight());
            s.setInt(8,object.getLectionHours());
            s.setInt(9,object.getPracticeHours());
            s.setInt(10,object.getLabsHours());
            s.setInt(11,object.getConsultHours());
            s.setInt(12,object.getExamHours());
            s.setInt(13,object.getCreditHours());
            s.setInt(14,object.getTestHours());
            s.setInt(15,object.getAudienceHours());
            s.setInt(16,object.getNonAudienceHours());
            s.setInt(17,object.getTotalHours());
            s.setInt(18, object.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void deleteTeacher(Integer id) throws SQLException {
        String sql = "DELETE FROM `teacher` "
                + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Collection<Cathedra> readAllCathedras() throws SQLException {
        String sql = "SELECT `id`, `name`, `phone`, `professorRate`, `docentRate`, `seniorTeacherRate`," +
                " `teacherRate`, `professorHours`, `docentHours`, `seniorTeacherHours`, `teacherHours` FROM `cathedra`";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<Cathedra> cathedra = new ArrayList<>();
            while(r.next()) {
                Cathedra object = new Cathedra();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setPhone(r.getString("phone"));
                object.setProfessorRate(r.getInt("professorRate"));
                object.setDocentRate(r.getInt("docentRate"));
                object.setSeniorTeacherRate(r.getInt("seniorTeacherRate"));
                object.setTeacherRate(r.getInt("teacherRate"));
                object.setProfessorHours(r.getInt("professorHours"));
                object.setDocentHours(r.getInt("docentHours"));
                object.setSeniorTeacherHours(r.getInt("seniorTeacherHours"));
                object.setTeacherHours(r.getInt("teacherHours"));
                cathedra.add(object);
            }
            return cathedra;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Collection<Cathedra> readAllSortedCathedras(String parameter) throws SQLException {
        String sql = "SELECT `id`, `name`, `phone`, `professorRate`, `docentRate`, `seniorTeacherRate`," +
                " `teacherRate`, `professorHours`, `docentHours`, `seniorTeacherHours`, `teacherHours` FROM `cathedra` ORDER BY `" + parameter + "` DESC";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<Cathedra> cathedra = new ArrayList<>();
            while(r.next()) {
                Cathedra object = new Cathedra();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setPhone(r.getString("phone"));
                object.setProfessorRate(r.getInt("professorRate"));
                object.setDocentRate(r.getInt("docentRate"));
                object.setSeniorTeacherRate(r.getInt("seniorTeacherRate"));
                object.setTeacherRate(r.getInt("teacherRate"));
                object.setProfessorHours(r.getInt("professorHours"));
                object.setDocentHours(r.getInt("docentHours"));
                object.setSeniorTeacherHours(r.getInt("seniorTeacherHours"));
                object.setTeacherHours(r.getInt("teacherHours"));
                cathedra.add(object);
            }
            return cathedra;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Cathedra readCathedraById(Integer id) throws SQLException {
        String sql = "SELECT `id`, `name`, `phone`, `professorRate`, `docentRate`, `seniorTeacherRate`," +
                "`teacherRate`, `professorHours`, `docentHours`, `seniorTeacherHours`, " +
                "`teacherHours` FROM `cathedra` WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            Cathedra object = null;
            if(r.next()) {
                object = new Cathedra();
                object.setId(id);
                object.setName(r.getString("name"));
                object.setPhone(r.getString("phone"));
                object.setProfessorRate(r.getInt("professorRate"));
                object.setDocentRate(r.getInt("docentRate"));
                object.setSeniorTeacherRate(r.getInt("seniorTeacherRate"));
                object.setTeacherRate(r.getInt("teacherRate"));
                object.setProfessorHours(r.getInt("professorHours"));
                object.setDocentHours(r.getInt("docentHours"));
                object.setSeniorTeacherHours(r.getInt("seniorTeacherHours"));
                object.setTeacherHours(r.getInt("teacherHours"));
            }
            return object;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }



    public static void createCathedra(Cathedra object) throws SQLException {
        String sql = "INSERT INTO `cathedra`(`name`, `phone`, `professorRate`, `docentRate`, `seniorTeacherRate`," +
                "`teacherRate`, `professorHours`, `docentHours`, `seniorTeacherHours`," +
                "`teacherHours`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getName());
            s.setString(2, object.getPhone());
            s.setInt(3, object.getProfessorRate());
            s.setInt(4, object.getDocentRate());
            s.setInt(5, object.getSeniorTeacherHours());
            s.setInt(6, object.getTeacherRate());
            s.setInt(7, object.getProfessorHours());
            s.setInt(8, object.getDocentHours());
            s.setInt(9, object.getSeniorTeacherHours());
            s.setInt(10, object.getTeacherHours());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void updateCathedra(Cathedra object) throws SQLException {
        String sql = "UPDATE `cathedra` SET `name` = ?, " +
                "`phone` = ?, `professorRate` = ?, `docentRate` = ?, `SeniorTeacherRate` = ?," +
                "`teacherRate` = ?, `professorHours` = ?, `docentHours` = ?," +
                " `SeniorTeacherHours` = ?, `teacherHours` = ? WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getName());
            s.setString(2, object.getPhone());
            s.setInt(3, object.getProfessorRate());
            s.setInt(4, object.getDocentRate());
            s.setInt(5, object.getSeniorTeacherHours());
            s.setInt(6, object.getTeacherRate());
            s.setInt(7, object.getProfessorHours());
            s.setInt(8, object.getDocentHours());
            s.setInt(9, object.getSeniorTeacherHours());
            s.setInt(10, object.getTeacherHours());
            s.setInt(11, object.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void deleteCathedra(Integer id) throws SQLException {
        String sql = "DELETE FROM `cathedra` "
                + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }


    public static User checkUser(User user) throws SQLException {
        String sql = "SELECT `role` "
                + "FROM `users` "
                + "WHERE `login` = ? AND `password` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, user.getLogin());
            s.setString(2, user.getPassword());
            r = s.executeQuery();
            if(r.next()) {
                User object = new User();
                object.setLogin(user.getLogin());
                object.setPassword(user.getPassword());
                object.setRole(r.getString("role"));
                return object;
            }
            return null;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static Collection<User> readAllUsers() throws SQLException {
        String sql = "SELECT `login`, `password`, `role` FROM `users`";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<User> users = new ArrayList<>();
            while(r.next()) {
                User object = new User();
                object.setLogin(r.getString("login"));
                object.setPassword(r.getString("password"));
                object.setRole(r.getString("role"));
                users.add(object);
            }
            return users;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static User readUserByLogin(String login) throws SQLException {
        String sql = "SELECT `login`, `password`, `role` FROM `users` WHERE `login` = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, login);
            r = s.executeQuery();
            User object = null;
            if(r.next()) {
                object = new User();
                object.setLogin(login);
                object.setPassword(r.getString("password"));
                object.setRole(r.getString("role"));
            }
            return object;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void createUser(User object) throws SQLException {
        String sql = "INSERT INTO `users`(`login`, `password`, `role`) VALUES (?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getLogin());
            s.setString(2, object.getPassword());
            s.setString(3, object.getRole());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void updateUser(User object) throws SQLException {
        String sql = "UPDATE `users` SET `login` = ?, " +
                "`password` = ?, `role` = ?  WHERE `login` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getLogin());
            s.setString(2, object.getPassword());
            s.setString(3, object.getRole());
            s.setString(4, object.getLogin());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void deleteUser(String login) throws SQLException {
        String sql = "DELETE FROM `users` "
                + "WHERE `login` = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, login);
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,
                jdbcUser,
                jdbcPassword);
    }
}