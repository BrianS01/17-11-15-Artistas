/*
 *      Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Artista;
import util.DbUtil;

public class ArtistaDAO
{
    private Connection connection;

    public ArtistaDAO()
    {
        connection = DbUtil.getConnection();
    }

    public void addUser(Artista user)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into artista(cedula,nombre,edad,obra,estilo) values (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, user.getCedula());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setInt(3, user.getEdad());
            preparedStatement.setString(4, user.getObra());
            preparedStatement.setString(5, user.getEstilo());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(int cedula)
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from artista where cedula=?");
            // Parameters start with 1
            preparedStatement.setInt(1, cedula);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateUser(Artista user)
    {
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement("update artista set cedula=?, nombre=?, edad=?, obra=?, estilo=?" + "where cedula=?");
            preparedStatement.setInt(1, user.getCedula());
            preparedStatement.setString(2, user.getNombre());
            preparedStatement.setInt(3, user.getEdad());
            preparedStatement.setString(4, user.getObra());
            preparedStatement.setString(5, user.getEstilo());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Artista> getAllUsers()
    {
        List<Artista> users = new ArrayList<Artista>();
        try
        {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next())
            {
                Artista user = new Artista();
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return users;
    }

    public Artista getUserById(int userId)
    {
        Artista user = new Artista();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
}