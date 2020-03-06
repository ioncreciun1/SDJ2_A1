package model;

import java.util.ArrayList;

public class TemperatureList
{
   private ArrayList<Temperature> list;
   private ArrayList<Temperature> outdoor;

   public TemperatureList()
   {
      this.outdoor = new ArrayList<>();
      this.list = new ArrayList<>();
   }

   public void addTemperature(Temperature temperature)
   {
      list.add(temperature);
   }
   public void addOutdoorTemperature(Temperature temperature)
   {
      outdoor.add(temperature);
   }

   public Temperature getTemperature(int index)
   {
      if (index >= 0 && index < list.size())
      {
         return list.get(index);
      }
      return null;
   }

   public Temperature getLastTemperature(String id)
   {
      if (list.size() < 1)
      {
         return null;
      }
      if (id == null)
      {
         return list.get(list.size()-1);
      }
      for (int i=list.size()-1; i>=0; i--)
      {
         if (id.equals(list.get(i).getId()))
         {
            return list.get(i);
         }
      }
      return null;
   }
   public ArrayList<Temperature> getAllTemp()
   {
      ArrayList<Temperature> all = new ArrayList<>();
      for(int i=0;i<list.size();i++)
      {
         all.add(list.get(i));
      }
      for(int i=0;i<outdoor.size();i++)
      {
         all.add(outdoor.get(i));
      }
      return all;
   }
   public int getSize()
   {
      return list.size();
   }

   public String toString()
   {
      String s = "{";
      for (int i = 0; i < list.size(); i++)
      {
         s += list.get(i);
         if (i < list.size() - 1)
         {
            s += ", ";
         }
      }
      return s;
   }

   public Temperature getLastOutdoorTemperature(String id)
   {
      if (outdoor.size() < 1)
      {
         return null;
      }
      if (id == null)
      {
         return outdoor.get(outdoor.size()-1);
      }
      for (int i=outdoor.size()-1; i>=0; i--)
      {
         if (id.equals(outdoor.get(i).getId()))
         {
            return outdoor.get(i);
         }
      }
      return null;
   }
}
