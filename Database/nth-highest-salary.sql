CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
      declare temp int  default 0;
       declare size int  default 0;
      
      
     set size = ( select count(distinct(salary)) from employee);
     
     set temp = size - N ;
     if N > size then
        return null;
     end if;   
     
  RETURN (
      # Write your MySQL query statement below.
    
      
      select salary 
	from (select distinct(salary) as salary from employee)as e 
		order by salary  limit 1 offset temp
      
  );
END