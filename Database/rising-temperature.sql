# Write your MySQL query statement below


select distinct(a.id) from Weather a , Weather b
where (select  DATEDIFF(a.recordDate , b.recordDate ) as dat ) = 1  and a.Temperature > b.Temperature ; 
