package org.example.homework.database;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    List<Record> records = new ArrayList<>();

    @Override
    public String toString() {
        return "Database{" +
                "records=" + records +
                '}';
    }

    public Database() {
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void save (Record rec) {
        List<Record> temp = new ArrayList<>(records);
        boolean status = false;
        for (int i = 0; i < temp.size(); i++){
            if (Objects.equals(temp.get(i).getId(), rec.getId())){
                temp.set(i, rec);
                status = true;
                break;
            } else if (rec.getId() == null) {
                rec.setId(findLargestIdInList(temp) + 1);
                temp.add(rec);
                status = true;
                break;
            }
        }
        if (status == false){
            temp.add(rec);
        }
        setRecords(temp);
    }

    public int findLargestIdInList (List<Record> records){
        int max = records.get(0).getId();
        for (int i = 1; i < records.size(); i++){
            if (records.get(i-1).getId() < records.get(i).getId()){
                max = records.get(i).getId();
            }
        }
        return max;
    }

    public String find (int id){
        for (int i = 0; i < records.size(); i++){
              if (records.get(i).getId() == id){
                  return records.get(i).toString();
              }
        }      
        return null;
    }

    public String delete (int id){
        String del = null;
        for (int i = 0; i < records.size(); i++){
            if (records.get(i).getId() == id){
                del = records.get(i).toString();
                records.remove(records.get(i));
            }
        }
        return del;
    }

    public String findByCreatedAtAfter (ZonedDateTime time){
        List<Record> getRecordsAfterCreatedAtTime = new ArrayList<>();
        for (int i = 0; i < records.size(); i++){
            if (records.get(i).getCreatedAt().isEqual(time) || records.get(i).getCreatedAt().isAfter(time)){
                getRecordsAfterCreatedAtTime.add(records.get(i));
            }
        }
        return getRecordsAfterCreatedAtTime.toString();
    }

    public String findByUpdatedAtAfter (ZonedDateTime time){
        List<Record> getRecordsAfterUpdatedAtTime = new ArrayList<>();
        for (int i = 0; i < records.size(); i++){
            if (records.get(i).getUpdatedAt().isEqual(time) || records.get(i).getUpdatedAt().isAfter(time)){
                getRecordsAfterUpdatedAtTime.add(records.get(i));
            }
        }
        return getRecordsAfterUpdatedAtTime.toString();
    }
}
