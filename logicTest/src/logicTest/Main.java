package logicTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	 public static void main(String[] args) {
		 	Parser parser = new Parser();
		 
		 
	        // Job metadata
	        Map<String, Job> jobs = new HashMap<>();
	        jobs = parser.jobs();
	        

	        // Employee data
	        List<Employee> employees = new ArrayList<>();
	        employees = parser.employees();
	        
	        
	        

	        // Process each employee's time punches
	        for (Employee employee : employees) {
	        	double totalHours = 0.0;
	            double regularHours = 0.0;
	            double overtimeHours = 0.0;
	            double doubleTimeHours = 0.0;
	            double wageTotal = 0.0;
	            double benefitTotal = 0.0;

	            for (TimePunch punch : employee.timePunches) {
	                Job job = jobs.get(punch.job);
	                
	                double hoursWorked = punch.calculateMinutes() / 60.0;
	                
	                
	                double excess = 0;
	                double differences = 0;
	                double excessDouble = 0;
	                
	                
	                //System.out.println(totalHours);
	                //System.out.println(hoursWorked);
	                
	                
	                if(hoursWorked + totalHours <= 40.0) {
	                	regularHours = regularHours + hoursWorked;
	                	wageTotal = wageTotal + hoursWorked * job.rate;
	                	
	                	
	                } else if(hoursWorked + totalHours > 48.0) {
	                	if(totalHours <= 40.0) {
	                		excess = totalHours + hoursWorked - 40;
	                		excessDouble = excess - 8;
	                		excess = excess - excessDouble;
	                		differences = hoursWorked - excessDouble - excess;
	                	} else if(totalHours > 40) {
	                		differences = 0;
	                		excess = hoursWorked;
	                		if(totalHours >= 48) {
	                			excess = 0;
	                			excessDouble = hoursWorked;
	                		} else {
	                			excessDouble = totalHours + hoursWorked - 48;
	                			excess = hoursWorked - excessDouble;
	                			
	                		}
	                		
	                		
	                	}

	                		
	                		

	                	regularHours = regularHours + differences;
	                	overtimeHours = overtimeHours + excess;
	                	doubleTimeHours = doubleTimeHours + excessDouble;
	                	wageTotal = wageTotal + (differences * job.rate) + (excess * (job.rate * 1.5) + (excessDouble * (job.rate * 2)));
	                	
	                } else if (hoursWorked + totalHours >= 40.0) {
	                	if(totalHours <= 40.0) {
	                		
	                		excess = totalHours + hoursWorked - 40;
	                		differences = hoursWorked - excess;

	                		
	                	} else {
	                		excess = hoursWorked;
	                	}
                		regularHours = regularHours + differences;
                		overtimeHours = overtimeHours + excess;
                		wageTotal = wageTotal + (differences * job.rate) + (excess * (job.rate * 1.5) );
	                } 
	                

	                // Calculate benefits total
	                benefitTotal += hoursWorked * job.benefitsRate;
	                totalHours = totalHours + hoursWorked;
	            }
	            
	            //round everything
	            regularHours = round(regularHours);
	            overtimeHours = round(overtimeHours);
	            doubleTimeHours = round(doubleTimeHours);
	            wageTotal = round(wageTotal);
	            benefitTotal = round(benefitTotal);
	          
	            
	            

	            // Output the result for the current employee
	            System.out.println("Employee: " + employee.name);
	            //System.out.println("TotalHours " + totalHours);
	            System.out.println("Regular Hours: " + regularHours);
	            System.out.println("Overtime Hours: " + overtimeHours);
	            System.out.println("Double Time Hours: " + doubleTimeHours);
	            System.out.println("Wage Total: " + wageTotal);
	            System.out.println("Benefit Total: " + benefitTotal);
	            System.out.println();
	        }
	    }
	 	public static double round(double value) {
	 		value = Math.round(value * 10000);
	 		value = value / 10000;
	 		return value;
	 	}

}
