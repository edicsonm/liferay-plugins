/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.socialcoding.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.socialcoding.NoSuchJIRAActionException;
import com.liferay.socialcoding.model.JIRAAction;
import com.liferay.socialcoding.model.impl.JIRAActionImpl;
import com.liferay.socialcoding.model.impl.JIRAActionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="JIRAActionPersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       JIRAActionPersistence
 * @see       JIRAActionUtil
 * @generated
 */
public class JIRAActionPersistenceImpl extends BasePersistenceImpl<JIRAAction>
	implements JIRAActionPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = JIRAActionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_JIRAUSERID = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByJiraUserId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_JIRAUSERID = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByJiraUserId", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_JIRAISSUEID = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByJiraIssueId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_JIRAISSUEID = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByJiraIssueId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_TYPE = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByType",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByType", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(JIRAAction jiraAction) {
		EntityCacheUtil.putResult(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionImpl.class, jiraAction.getPrimaryKey(), jiraAction);
	}

	public void cacheResult(List<JIRAAction> jiraActions) {
		for (JIRAAction jiraAction : jiraActions) {
			if (EntityCacheUtil.getResult(
						JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
						JIRAActionImpl.class, jiraAction.getPrimaryKey(), this) == null) {
				cacheResult(jiraAction);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(JIRAActionImpl.class.getName());
		EntityCacheUtil.clearCache(JIRAActionImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public void clearCache(JIRAAction jiraAction) {
		EntityCacheUtil.removeResult(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionImpl.class, jiraAction.getPrimaryKey());
	}

	public JIRAAction create(long jiraActionId) {
		JIRAAction jiraAction = new JIRAActionImpl();

		jiraAction.setNew(true);
		jiraAction.setPrimaryKey(jiraActionId);

		return jiraAction;
	}

	public JIRAAction remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	public JIRAAction remove(long jiraActionId)
		throws NoSuchJIRAActionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JIRAAction jiraAction = (JIRAAction)session.get(JIRAActionImpl.class,
					new Long(jiraActionId));

			if (jiraAction == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + jiraActionId);
				}

				throw new NoSuchJIRAActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					jiraActionId);
			}

			return remove(jiraAction);
		}
		catch (NoSuchJIRAActionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public JIRAAction remove(JIRAAction jiraAction) throws SystemException {
		for (ModelListener<JIRAAction> listener : listeners) {
			listener.onBeforeRemove(jiraAction);
		}

		jiraAction = removeImpl(jiraAction);

		for (ModelListener<JIRAAction> listener : listeners) {
			listener.onAfterRemove(jiraAction);
		}

		return jiraAction;
	}

	protected JIRAAction removeImpl(JIRAAction jiraAction)
		throws SystemException {
		jiraAction = toUnwrappedModel(jiraAction);

		Session session = null;

		try {
			session = openSession();

			if (jiraAction.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(JIRAActionImpl.class,
						jiraAction.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(jiraAction);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionImpl.class, jiraAction.getPrimaryKey());

		return jiraAction;
	}

	public JIRAAction updateImpl(
		com.liferay.socialcoding.model.JIRAAction jiraAction, boolean merge)
		throws SystemException {
		jiraAction = toUnwrappedModel(jiraAction);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, jiraAction, merge);

			jiraAction.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
			JIRAActionImpl.class, jiraAction.getPrimaryKey(), jiraAction);

		return jiraAction;
	}

	protected JIRAAction toUnwrappedModel(JIRAAction jiraAction) {
		if (jiraAction instanceof JIRAActionImpl) {
			return jiraAction;
		}

		JIRAActionImpl jiraActionImpl = new JIRAActionImpl();

		jiraActionImpl.setNew(jiraAction.isNew());
		jiraActionImpl.setPrimaryKey(jiraAction.getPrimaryKey());

		jiraActionImpl.setJiraActionId(jiraAction.getJiraActionId());
		jiraActionImpl.setJiraUserId(jiraAction.getJiraUserId());
		jiraActionImpl.setCreateDate(jiraAction.getCreateDate());
		jiraActionImpl.setModifiedDate(jiraAction.getModifiedDate());
		jiraActionImpl.setJiraIssueId(jiraAction.getJiraIssueId());
		jiraActionImpl.setType(jiraAction.getType());
		jiraActionImpl.setBody(jiraAction.getBody());
		jiraActionImpl.setJiraGroupName(jiraAction.getJiraGroupName());

		return jiraActionImpl;
	}

	public JIRAAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	public JIRAAction findByPrimaryKey(long jiraActionId)
		throws NoSuchJIRAActionException, SystemException {
		JIRAAction jiraAction = fetchByPrimaryKey(jiraActionId);

		if (jiraAction == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + jiraActionId);
			}

			throw new NoSuchJIRAActionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				jiraActionId);
		}

		return jiraAction;
	}

	public JIRAAction fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	public JIRAAction fetchByPrimaryKey(long jiraActionId)
		throws SystemException {
		JIRAAction jiraAction = (JIRAAction)EntityCacheUtil.getResult(JIRAActionModelImpl.ENTITY_CACHE_ENABLED,
				JIRAActionImpl.class, jiraActionId, this);

		if (jiraAction == null) {
			Session session = null;

			try {
				session = openSession();

				jiraAction = (JIRAAction)session.get(JIRAActionImpl.class,
						new Long(jiraActionId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (jiraAction != null) {
					cacheResult(jiraAction);
				}

				closeSession(session);
			}
		}

		return jiraAction;
	}

	public List<JIRAAction> findByJiraUserId(String jiraUserId)
		throws SystemException {
		return findByJiraUserId(jiraUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	public List<JIRAAction> findByJiraUserId(String jiraUserId, int start,
		int end) throws SystemException {
		return findByJiraUserId(jiraUserId, start, end, null);
	}

	public List<JIRAAction> findByJiraUserId(String jiraUserId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				jiraUserId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JIRAAction> list = (List<JIRAAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_JIRAUSERID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_JIRAACTION_WHERE);

				if (jiraUserId == null) {
					query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_1);
				}
				else {
					if (jiraUserId.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_3);
					}
					else {
						query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (jiraUserId != null) {
					qPos.add(jiraUserId);
				}

				list = (List<JIRAAction>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<JIRAAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_JIRAUSERID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public JIRAAction findByJiraUserId_First(String jiraUserId,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		List<JIRAAction> list = findByJiraUserId(jiraUserId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("jiraUserId=");
			msg.append(jiraUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction findByJiraUserId_Last(String jiraUserId,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		int count = countByJiraUserId(jiraUserId);

		List<JIRAAction> list = findByJiraUserId(jiraUserId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("jiraUserId=");
			msg.append(jiraUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction[] findByJiraUserId_PrevAndNext(long jiraActionId,
		String jiraUserId, OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		JIRAAction jiraAction = findByPrimaryKey(jiraActionId);

		Session session = null;

		try {
			session = openSession();

			JIRAAction[] array = new JIRAActionImpl[3];

			array[0] = getByJiraUserId_PrevAndNext(session, jiraAction,
					jiraUserId, orderByComparator, true);

			array[1] = jiraAction;

			array[2] = getByJiraUserId_PrevAndNext(session, jiraAction,
					jiraUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JIRAAction getByJiraUserId_PrevAndNext(Session session,
		JIRAAction jiraAction, String jiraUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JIRAACTION_WHERE);

		if (jiraUserId == null) {
			query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_1);
		}
		else {
			if (jiraUserId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_3);
			}
			else {
				query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (jiraUserId != null) {
			qPos.add(jiraUserId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(jiraAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JIRAAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	public List<JIRAAction> findByJiraIssueId(long jiraIssueId)
		throws SystemException {
		return findByJiraIssueId(jiraIssueId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	public List<JIRAAction> findByJiraIssueId(long jiraIssueId, int start,
		int end) throws SystemException {
		return findByJiraIssueId(jiraIssueId, start, end, null);
	}

	public List<JIRAAction> findByJiraIssueId(long jiraIssueId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(jiraIssueId),
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JIRAAction> list = (List<JIRAAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_JIRAISSUEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_JIRAACTION_WHERE);

				query.append(_FINDER_COLUMN_JIRAISSUEID_JIRAISSUEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraIssueId);

				list = (List<JIRAAction>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<JIRAAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_JIRAISSUEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public JIRAAction findByJiraIssueId_First(long jiraIssueId,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		List<JIRAAction> list = findByJiraIssueId(jiraIssueId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("jiraIssueId=");
			msg.append(jiraIssueId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction findByJiraIssueId_Last(long jiraIssueId,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		int count = countByJiraIssueId(jiraIssueId);

		List<JIRAAction> list = findByJiraIssueId(jiraIssueId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("jiraIssueId=");
			msg.append(jiraIssueId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction[] findByJiraIssueId_PrevAndNext(long jiraActionId,
		long jiraIssueId, OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		JIRAAction jiraAction = findByPrimaryKey(jiraActionId);

		Session session = null;

		try {
			session = openSession();

			JIRAAction[] array = new JIRAActionImpl[3];

			array[0] = getByJiraIssueId_PrevAndNext(session, jiraAction,
					jiraIssueId, orderByComparator, true);

			array[1] = jiraAction;

			array[2] = getByJiraIssueId_PrevAndNext(session, jiraAction,
					jiraIssueId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JIRAAction getByJiraIssueId_PrevAndNext(Session session,
		JIRAAction jiraAction, long jiraIssueId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JIRAACTION_WHERE);

		query.append(_FINDER_COLUMN_JIRAISSUEID_JIRAISSUEID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(jiraIssueId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(jiraAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JIRAAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	public List<JIRAAction> findByType(String type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<JIRAAction> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	public List<JIRAAction> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				type,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JIRAAction> list = (List<JIRAAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TYPE,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_JIRAACTION_WHERE);

				if (type == null) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_1);
				}
				else {
					if (type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TYPE_TYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_TYPE_TYPE_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				list = (List<JIRAAction>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<JIRAAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TYPE, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	public JIRAAction findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		List<JIRAAction> list = findByType(type, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		int count = countByType(type);

		List<JIRAAction> list = findByType(type, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchJIRAActionException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public JIRAAction[] findByType_PrevAndNext(long jiraActionId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchJIRAActionException, SystemException {
		JIRAAction jiraAction = findByPrimaryKey(jiraActionId);

		Session session = null;

		try {
			session = openSession();

			JIRAAction[] array = new JIRAActionImpl[3];

			array[0] = getByType_PrevAndNext(session, jiraAction, type,
					orderByComparator, true);

			array[1] = jiraAction;

			array[2] = getByType_PrevAndNext(session, jiraAction, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JIRAAction getByType_PrevAndNext(Session session,
		JIRAAction jiraAction, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JIRAACTION_WHERE);

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else {
			if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(JIRAActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (type != null) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(jiraAction);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JIRAAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	public List<JIRAAction> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<JIRAAction> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<JIRAAction> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<JIRAAction> list = (List<JIRAAction>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_JIRAACTION);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}

				else {
					sql = _SQL_SELECT_JIRAACTION.concat(JIRAActionModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<JIRAAction>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<JIRAAction>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<JIRAAction>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByJiraUserId(String jiraUserId) throws SystemException {
		for (JIRAAction jiraAction : findByJiraUserId(jiraUserId)) {
			remove(jiraAction);
		}
	}

	public void removeByJiraIssueId(long jiraIssueId) throws SystemException {
		for (JIRAAction jiraAction : findByJiraIssueId(jiraIssueId)) {
			remove(jiraAction);
		}
	}

	public void removeByType(String type) throws SystemException {
		for (JIRAAction jiraAction : findByType(type)) {
			remove(jiraAction);
		}
	}

	public void removeAll() throws SystemException {
		for (JIRAAction jiraAction : findAll()) {
			remove(jiraAction);
		}
	}

	public int countByJiraUserId(String jiraUserId) throws SystemException {
		Object[] finderArgs = new Object[] { jiraUserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JIRAUSERID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_JIRAACTION_WHERE);

				if (jiraUserId == null) {
					query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_1);
				}
				else {
					if (jiraUserId.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_3);
					}
					else {
						query.append(_FINDER_COLUMN_JIRAUSERID_JIRAUSERID_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (jiraUserId != null) {
					qPos.add(jiraUserId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JIRAUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByJiraIssueId(long jiraIssueId) throws SystemException {
		Object[] finderArgs = new Object[] { new Long(jiraIssueId) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_JIRAISSUEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_JIRAACTION_WHERE);

				query.append(_FINDER_COLUMN_JIRAISSUEID_JIRAISSUEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jiraIssueId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JIRAISSUEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByType(String type) throws SystemException {
		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_JIRAACTION_WHERE);

				if (type == null) {
					query.append(_FINDER_COLUMN_TYPE_TYPE_1);
				}
				else {
					if (type.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_TYPE_TYPE_3);
					}
					else {
						query.append(_FINDER_COLUMN_TYPE_TYPE_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (type != null) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_JIRAACTION);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.socialcoding.model.JIRAAction")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JIRAAction>> listenersList = new ArrayList<ModelListener<JIRAAction>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JIRAAction>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = JIRAActionPersistence.class)
	protected JIRAActionPersistence jiraActionPersistence;
	@BeanReference(type = JIRAChangeGroupPersistence.class)
	protected JIRAChangeGroupPersistence jiraChangeGroupPersistence;
	@BeanReference(type = JIRAChangeItemPersistence.class)
	protected JIRAChangeItemPersistence jiraChangeItemPersistence;
	@BeanReference(type = JIRAIssuePersistence.class)
	protected JIRAIssuePersistence jiraIssuePersistence;
	@BeanReference(type = SVNRepositoryPersistence.class)
	protected SVNRepositoryPersistence svnRepositoryPersistence;
	@BeanReference(type = SVNRevisionPersistence.class)
	protected SVNRevisionPersistence svnRevisionPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_JIRAACTION = "SELECT jiraAction FROM JIRAAction jiraAction";
	private static final String _SQL_SELECT_JIRAACTION_WHERE = "SELECT jiraAction FROM JIRAAction jiraAction WHERE ";
	private static final String _SQL_COUNT_JIRAACTION = "SELECT COUNT(jiraAction) FROM JIRAAction jiraAction";
	private static final String _SQL_COUNT_JIRAACTION_WHERE = "SELECT COUNT(jiraAction) FROM JIRAAction jiraAction WHERE ";
	private static final String _FINDER_COLUMN_JIRAUSERID_JIRAUSERID_1 = "jiraAction.jiraUserId IS NULL";
	private static final String _FINDER_COLUMN_JIRAUSERID_JIRAUSERID_2 = "jiraAction.jiraUserId = ?";
	private static final String _FINDER_COLUMN_JIRAUSERID_JIRAUSERID_3 = "(jiraAction.jiraUserId IS NULL OR jiraAction.jiraUserId = ?)";
	private static final String _FINDER_COLUMN_JIRAISSUEID_JIRAISSUEID_2 = "jiraAction.jiraIssueId = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "jiraAction.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "jiraAction.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(jiraAction.type IS NULL OR jiraAction.type = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jiraAction.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JIRAAction exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JIRAAction exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(JIRAActionPersistenceImpl.class);
}