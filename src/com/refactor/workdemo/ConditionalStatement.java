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
     *             log.error("�û�misId:{}������", misId);
     *             return 0;
     *         }
     *         //0û���κ�Ȩ�޲���Ҫ���� 1ֻ�и���Ȩ��  2 ֻ�й���ԱȨ�� 3 ȫ��
     *         int result = 0;
     *         DimEmployeeBean leader = dimEmployeeService.getEmpDeatilInfoByBdId(String.valueOf(emp.getSuperiorId()));
     *         if(leader == null){ return 0; }
     *         //����Ȩ�޴���
     *         int individualPermNum = commonAuthService.getIndividualPermNum(emp.getMisName());
     *         todo �������if̫����
     *         if(individualPermNum > 0) {
     *             leavePermNoticeService.commitLeaveNotice(emp);
     *             leavePermNoticeService.individualPermNoticeLeader(emp, leader);
     *             result += 1;
     *         }else {
     *             // û�и���Ȩ�ޣ��ж��Ƿ����û����Ա
     *             int memNumByMisName = userGroupService.getMemNumByMisName(misId);
     *             if(memNumByMisName > 0){
     *                 leavePermNoticeService.commitLeaveNotice(emp);
     *                 leavePermNoticeService.individualPermNoticeLeader(emp, leader);
     *                 result += 1;
     *             }
     *         }
     *         //����ԱȨ��
     *         int adminPermNum = commonAuthService.getAdminPermNum(emp.getMisName());
     *         if(adminPermNum > 0) {
     *             leavePermNoticeService.adminPermNotice(emp, leader, adminPermNum);
     *             result += 2;
     *         }
     *         return result;
     *     }
     */

    /**
     * ��΢�Ľ���һ��
     * public int commitLeave(String misId) {
     *         DimEmployeeBean emp = dimEmployeeService.getEmpDeatilInfoByMis(misId);
     *         if (null == emp) {
     *             log.error("�û�misId:{}������", misId);
     *             return 0;
     *         }
     *         //0û���κ�Ȩ�޲���Ҫ���� 1ֻ�и���Ȩ��  2 ֻ�й���ԱȨ�� 3 ȫ��
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
     *         //����ԱȨ��
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
