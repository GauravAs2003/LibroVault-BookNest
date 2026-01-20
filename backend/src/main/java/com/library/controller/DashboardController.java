//package com.library.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.library.service.DashboardService;
//
//@RestController
//@RequestMapping("/api/dashboard")
//@CrossOrigin(origins = "http://localhost:3000")
//public class DashboardController {
//
//    @Autowired
//    private DashboardService dashboardService;
//
//    @GetMapping("/stats")
//    public Map<String, Long> getDashboardStats() {
//
//        Map<String, Long> stats = new HashMap<>();
//
//        stats.put("totalBooks", dashboardService.getTotalAvailableBooks());
//        stats.put("borrowed", dashboardService.getTotalBorrowedBooks());
//        stats.put("differentBooks", dashboardService.getTotalDifferentBooks());
//
//        return stats;
//    }
//
//}

package com.library.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.library.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/stats")
	public Map<String, Long> getStats() {

		Map<String, Long> stats = new HashMap<>();

		stats.put("totalAvailableBooks", dashboardService.getTotalAvailableBooks());
		stats.put("totalBooksAdded", dashboardService.getTotalBooksAdded());
		stats.put("booksBorrowed", dashboardService.getBooksBorrowed());
		stats.put("pendingReturns", dashboardService.getPendingReturns());

		return stats;
	}
}
