package com.refactor.workdemo;

/**
 * @author songyi
 * @date 2021-02-07 16:52
 * @Description:
 */
public class ConditionalStatement {

    /**
     * public int commitLeave(String misId) {
     *         DimEmployeeBean emp = dimEmployeeService.getEmpDeatilInfoByMis(misId);
     *         if (null == emp) {
     *             log.error("用户misId:{}不存在", misId);
     *             return 0;
     *         }
     *         //0没有任何权限不需要处理 1只有个人权限  2 只有管理员权限 3 全有
     *         int result = 0;
     *         DimEmployeeBean leader = dimEmployeeService.getEmpDeatilInfoByBdId(String.valueOf(emp.getSuperiorId()));
     *         if(leader == null){ return 0; }
     *         //个人权限处理
     *         int individualPermNum = commonAuthService.getIndividualPermNum(emp.getMisName());
     *         todo 下面这个if太垃圾
     *         if(individualPermNum > 0) {
     *             leavePermNoticeService.commitLeaveNotice(emp);
     *             leavePermNoticeService.individualPermNoticeLeader(emp, leader);
     *             result += 1;
     *         }else {
     *             // 没有个人权限，判断是否是用户组成员
     *             int memNumByMisName = userGroupService.getMemNumByMisName(misId);
     *             if(memNumByMisName > 0){
     *                 leavePermNoticeService.commitLeaveNotice(emp);
     *                 leavePermNoticeService.individualPermNoticeLeader(emp, leader);
     *                 result += 1;
     *             }
     *         }
     *         //管理员权限
     *         int adminPermNum = commonAuthService.getAdminPermNum(emp.getMisName());
     *         if(adminPermNum > 0) {
     *             leavePermNoticeService.adminPermNotice(emp, leader, adminPermNum);
     *             result += 2;
     *         }
     *         return result;
     *     }
     */

    /**
     * 稍微改进了一版
     * public int commitLeave(String misId) {
     *         DimEmployeeBean emp = dimEmployeeService.getEmpDeatilInfoByMis(misId);
     *         if (null == emp) {
     *             log.error("用户misId:{}不存在", misId);
     *             return 0;
     *         }
     *         //0没有任何权限不需要处理 1只有个人权限  2 只有管理员权限 3 全有
     *         int result = 0;
     *         DimEmployeeBean leader = dimEmployeeService.getEmpDeatilInfoByBdId(String.valueOf(emp.getSuperiorId()));
     *         if(leader == null){ return 0; }
     *
     *         if(hasPersonPermOrInUseGroup(emp)){
     *             leavePermNoticeService.commitLeaveNotice(emp);
     *             leavePermNoticeService.individualPermNoticeLeader(emp, leader);
     *             result += 1;
     *         }
     *
     *         //管理员权限
     *         int adminPermNum = commonAuthService.getAdminPermNum(emp.getMisName());
     *         if(adminPermNum > 0) {
     *             leavePermNoticeService.adminPermNotice(emp, leader, adminPermNum);
     *             result += 2;
     *         }
     *         return result;
     *
     *     }
     *
     *     private boolean hasPersonPermOrInUseGroup(DimEmployeeBean emp) {
     *         return commonAuthService.getIndividualPermNum(emp.getMisName()) > 0 || userGroupService.getMemNumByMisName(emp.getMisName()) > 0;
     *     }
     */
}
